package com.github.gr1lzy.vcs_all_in_one.vcs.hg;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class HgUpdate implements Callable<ArrayList<String>> {
    private final String branch;

    public HgUpdate() {
        this.branch = "";
    }

    public HgUpdate(String branch) {
        this.branch = branch;
    }

    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Hg.hgBuilder().addArguments(new CommandArg("update"));
        if (branch != null) {
            builder.addArguments(new CommandArg(branch));
        }

        return new CommandLine(builder).call();
    }
}
