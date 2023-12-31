package com.github.gr1lzy.vcs_all_in_one.commands.repos;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

import java.util.concurrent.Callable;

@Command(name = "repos",
        description = "Performs operations with repositories",
        subcommands = {
                Add.class,
                List.class,
                Move.class,
                Remove.class,
                Clean.class
        })
public class Repos implements Callable<Integer> {
    @Spec
    CommandSpec spec;

    @Override
    public Integer call() {
        this.spec.commandLine().usage(System.out);
        return null;
    }
}
