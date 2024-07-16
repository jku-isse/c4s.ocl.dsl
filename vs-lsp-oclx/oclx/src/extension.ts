'use strict';

import * as net from 'net';

import { Trace } from 'vscode-jsonrpc';
import { workspace, ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, StreamInfo, Position as LSPosition, Location as LSLocation } from 'vscode-languageclient/node';
import AbstractCommand from "./commands/AbstractCommand";
import OclxEvaluateConstraintsCommand from "./commands/EvaluateConstraintsCommand";

let lc: LanguageClient;

export function activate(context: ExtensionContext) {
    // The server is a started as a separate app and listens on port 5007
    let connectionInfo = {
        port: 5007
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
        outputChannelName: 'OCLX Language Server'
    };

    // Create the language client and start the client.
    lc = new LanguageClient('Xtext Server', serverOptions, clientOptions);

    let evalCommand = new OclxEvaluateConstraintsCommand(lc);
    this.context.subscriptions.push(evalCommand.registerCommand());

    lc.setTrace(Trace.Verbose);
    let disposable = lc.start();
}

export function deactivate() {
    return lc.stop();
}