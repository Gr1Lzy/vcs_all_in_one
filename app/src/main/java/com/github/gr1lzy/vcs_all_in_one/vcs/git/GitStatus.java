package com.github.gr1lzy.vcs_all_in_one.vcs.git;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

class GitStatus implements Callable<ArrayList<String>> {
    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Git.gitBuilder().addArguments(
                new CommandArg("status"),
                new CommandArg("--porcelain"));
        return new CommandLine(builder).call();
    }
}
