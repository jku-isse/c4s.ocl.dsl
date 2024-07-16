import AbstractCommand from "./AbstractCommand";
import { window, workspace, commands, ExtensionContext, Uri, ProgressLocation } from 'vscode';
import { LanguageClient, LanguageClientOptions, StreamInfo, Position as LSPosition, Location as LSLocation } from 'vscode-languageclient/node';

export default class EvaluateConstraintsCommand extends AbstractCommand {
    private languageClient: LanguageClient;

    constructor(languageClient: LanguageClient) {
        super('oclx.evaluate');
        this.languageClient = languageClient;
    }

    protected async runCommand(): Promise<void> {

        let activeEditor = window.activeTextEditor;
        if (!activeEditor || !activeEditor.document || activeEditor.document.languageId !== 'oclx') {
            return;
        }

        try {
            await window.withProgress({
                location: ProgressLocation.Notification,
                title: "Please wait until constraint evaluation operation completes"
            }, async () => {
                const evalInfo = await this.languageClient.sendRequest('oclx.evaluate', activeEditor.document.uri.toString());
                window.showInformationMessage(`Constraint Evaluation Result: ${evalInfo}`);
            })
        } catch (ex) {
            console.log('error', `Failed to perform constraint evaluation: ${ex}`);
            window.showErrorMessage(`Failed to perform constraint evaluation: ${ex}`);
        }
    }
}