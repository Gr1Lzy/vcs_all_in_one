package com.github.gr1lzy.vcs_all_in_one.vcs.svn;

import com.github.gr1lzy.vcs_all_in_one.vcs.VCSCommit;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;
import com.github.gr1lzy.vcs_all_in_one.shell.Out;

import java.util.concurrent.Callable;

class SvnCommit implements Callable<VCSCommit> {
    private final String message;

    public SvnCommit(String message) {
        this.message = message;
    }

    @Override
    public VCSCommit call() throws Exception {
        // check if anything is staged
        CommandBuilder statusBuilder = Svn.svnBuilder()
                .addArguments(new CommandArg("status"));
        var status = new CommandLine(statusBuilder).call();
        if (status.isEmpty()) {
            Out.log("Nothing to commit.");
            return null;
        }

        // run commit command
        CommandBuilder commitBuilder = Svn.svnBuilder()
                .addArguments(new CommandArg("commit"), new CommandArg("-m", "\"" + message + "\"", " "));
        new CommandLine(commitBuilder).call();

        // get info about the commit created
        return SvnLog.customLog(new CommandArg("--limit", "1")).get(0);
    }
}
