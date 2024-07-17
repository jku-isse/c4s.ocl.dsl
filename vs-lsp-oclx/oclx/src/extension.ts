'use strict';

import { window, ExtensionContext } from 'vscode';
import AbstractCommand from "./commands/AbstractCommand";
import OclxEvaluateConstraintsCommand from "./commands/EvaluateConstraintsCommand";
import OclxLanguageClient from "./OclxLanguageClient";


class OclxClientExtension {

    private context: ExtensionContext;
    private languageClient: OclxLanguageClient;
    private commands: AbstractCommand[];
    

    public constructor (context: ExtensionContext) {
        this.context = context;
        // The server is a started as a separate app and listens on port 5007
        this.languageClient = new OclxLanguageClient(context, 5007);

        this.commands = [
            new OclxEvaluateConstraintsCommand(this.languageClient),
        ];
    }

    public async start(): Promise<void> {
        console.log('Starting oclx client');
        await this.languageClient.startViaWebsocket('ws://localhost:7171/lsp');
        console.log('client started');
        this.commands.forEach(command =>
            this.context.subscriptions.push(command.registerCommand())
            );  
    }

    public async stop(): Promise<void> {
        await this.languageClient.stop();
    }

    public getLanguageClient(): OclxLanguageClient {
        return this.languageClient;
    }
}

let client: OclxClientExtension;

export async function activate(context: ExtensionContext) {
    try {
		client = new OclxClientExtension(context);
		await client.start();
	} catch (ex) {
        window.showErrorMessage(`Failed to initialize Oclx client extension: ${ex}`);
	}
}

export async function deactivate(): Promise<void> {
	if (client) {
		await client.stop();
	}
}