import * as net from 'net';
import { WebSocket } from 'ws';
import { Trace } from 'vscode-jsonrpc';
import { workspace, ExtensionContext } from 'vscode';
import { integer, LanguageClient, LanguageClientOptions, StreamInfo } from "vscode-languageclient/node";
import { rejects } from 'assert';


export default class OclxLanguageClient {
    private lc: LanguageClient;
    private port;
    private context: ExtensionContext;

    constructor(context: ExtensionContext, port: integer) {
        this.port = port;
        this.context = context;
    }

    public async start(): Promise<void> {
        if (this.lc) {
            throw new Error('Oclx Language client has already been initialized');
        }
        let connectionInfo = {
            port: this.port
        };
        let serverOptions = () => {
            // Connect to language server via socket
            let socket = net.connect(connectionInfo);
            let result: StreamInfo = {
                writer: socket,
                reader: socket
            };
            return Promise.resolve(result);
        };

        let clientOptions: LanguageClientOptions = {
            documentSelector: ['oclx'],
            synchronize: {
                fileEvents: workspace.createFileSystemWatcher('**/*.*')
            },
        };

        // Create the language client and start the client.
        this.lc = new LanguageClient('OCLX Xtext LSP', serverOptions, clientOptions);
        this.lc.setTrace(Trace.Verbose);
        console.log('About to start language client:');
        await this.lc.start();
        
    }

    public async startViaWebsocket(endpoint: String): Promise<void> {
        if (this.lc) {
            throw new Error('Oclx Language client has already been initialized');
        }
        
        // Connect to language server via websocket
        const ws = new WebSocket(endpoint);
        console.log('Websocket connecting ...');
       // const connection = WebSocket.createWebSocketStream(ws, { encoding: 'utf8' });
       const connection = WebSocket.createWebSocketStream(ws);
        console.log('Websocket connected');

        let serverOptions = () => Promise.resolve<StreamInfo>({
            reader: connection,
            writer: connection,
        });

        let clientOptions: LanguageClientOptions = {
            documentSelector: ['oclx'],
            synchronize: {
                fileEvents: workspace.createFileSystemWatcher('**/*.*')
            },
        };
        console.log('Language client setting up ...');
        // Create the language client and start the client.
        this.lc = new LanguageClient('OCLX Xtext LSP', serverOptions, clientOptions);
        console.log('Language client setup, starting ...');
        this.lc.setTrace(Trace.Verbose);
        //Promise.resolve<void>(this.lc.start());
         //return this.lc.start()
            //.then(() => console.log("success") )
            //.catch(err => console.log("error "+err))
        console.log("State: "+this.lc.state);
        Promise.resolve<void>(this.lc.start());
        console.log("State: "+this.lc.state);
        //await this.lc.start()
    }

    public async stop(): Promise<void> {
        if (this.lc) {
            await this.lc.stop();
            this.lc = undefined;
        }
    }

    public getLanguageClient(): LanguageClient {
        if (this.lc) {
            return this.lc;
        } else {
            throw new Error('Oclx Language client is not initialized');
        }
    }

    public async requestEvalAllConstraints(documentUri: string): Promise<String>  {
        return await this.getLanguageClient().sendRequest('oclx.evaluate', {documentUri});
    }
}