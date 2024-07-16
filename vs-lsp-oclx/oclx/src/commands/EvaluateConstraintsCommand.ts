import AbstractCommand from "./AbstractCommand";
import { window } from 'vscode';
import  OclxLanguageClient from "../OclxLanguageClient";

export default class EvaluateConstraintsCommand extends AbstractCommand {
    private languageClient: OclxLanguageClient;

    constructor(languageClient: OclxLanguageClient) {
        super('oclx.evaluate');
        this.languageClient = languageClient;
    }

    protected async runCommand(): Promise<void> {

        let activeEditor = window.activeTextEditor;
        if (!activeEditor || !activeEditor.document || activeEditor.document.languageId !== 'oclx') {
            return;
        }
        try {
                let uri = activeEditor.document.uri.toString();
                let pos = activeEditor.selection.active.toString();
                let test = "Test"
                console.log(`Requesting execution for: ${uri} at pos: ${pos}`);
                const evalInfo = await this.languageClient.requestEvalAllConstraints(uri);
                console.log(`Constraint Evaluation Result: ${evalInfo}`);
                window.showInformationMessage(`Constraint Evaluation Result: ${evalInfo}`);
        } catch (ex) {
            console.log('error', `Failed to perform constraint evaluation: ${ex}`);
            window.showErrorMessage(`Failed to perform constraint evaluation: ${ex}`);
        }
    }
}