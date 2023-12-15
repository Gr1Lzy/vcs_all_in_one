package com.github.gr1lzy.vcs_all_in_one.vcs.hg;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.Out;
import com.github.gr1lzy.vcs_all_in_one.vcs.VCSCommit;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.concurrent.Callable;

class HgCommit implements Callable<VCSCommit> {
    private final String message;

    public HgCommit(String message) {
        this.message = message;
    }

    @Override
    public VCSCommit call() throws Exception {
        // check if anything is staged
        CommandBuilder statusBuilder = Hg.hgBuilder()
                .addArguments(new CommandArg("status"));
        var status = new CommandLine(statusBuilder).call();
        if (status.isEmpty()) {
            Out.log("Nothing to commit.");
            return null;
        }

        // run commit command
        CommandBuilder commitBuilder = Hg.hgBuilder()
                .addArguments(new CommandArg("commit"), new CommandArg("-m", "\"" + message + "\"", " "));
        new CommandLine(commitBuilder).call();

        // get info about the commit created
        return HgLog.customLog(new CommandArg("--limit", "1")).get(0);
    }
}
