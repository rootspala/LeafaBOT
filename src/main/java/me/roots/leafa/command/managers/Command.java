package me.roots.leafa.command.managers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {

    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event);
    void executed(boolean sucessful, MessageReceivedEvent event);
    String help();

    // <prefix>invoke argument1 argument2 argument3 ...

}
