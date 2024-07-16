import * as net from 'net';
import { WebSocket } from 'ws';
import { Trace } from 'vscode-jsonrpc';
import { workspace, ExtensionContext } from 'vscode';
import { integer, LanguageClient, LanguageClientOptions, StreamInfo } from "vscode-languageclient/node";


export default class OclxLanguageClient {
    private lc?: LanguageClient;
    private port;

    constructor(context: ExtensionContext, port: integer) {
        this.port = port;
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
        await this.lc.start();
        
    }

    public async startViaWebsocket(endpoint: String): Promise<void> {
        if (this.lc) {
            throw new Error('Oclx Language client has already been initialized');
        }
        
        let serverOptions = () => {
            // Connect to language server via websocket
            const ws = new WebSocket(endpoint);
            const connection = WebSocket.createWebSocketStream(ws);
            // connection.on("data", function (chunk) {
            //     console.log(new TextDecoder().decode(chunk));
            // });
            let result: StreamInfo = {
                reader: connection,
                writer: connection
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
        await this.lc.start();
        
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