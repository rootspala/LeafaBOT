package me.roots.leafa.command.managers;

import me.roots.leafa.command.pivaman.BotClass;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().startsWith(BotClass.PREFIX)) {
            CommandHandler.handleCommand(CommandHandler.parser.parse(event.getMessage().getContentDisplay(), event));
        }
    }
}