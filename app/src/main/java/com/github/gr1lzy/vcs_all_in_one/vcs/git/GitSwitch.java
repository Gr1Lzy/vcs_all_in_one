package com.github.gr1lzy.vcs_all_in_one.vcs.git;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class GitSwitch implements Callable<ArrayList<String>> {
    private final String branch;

    public GitSwitch(String branch) {
        this.branch = branch;
    }

    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Git.gitBuilder().addArguments(
                new CommandArg("switch"),
                new CommandArg(branch));
        return new CommandLine(builder).call();
    }
}
