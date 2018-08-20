package me.roots.leafa.command.commands.admin;

import me.roots.leafa.command.managers.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandDeveloper implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        switch (args[0]) {
            case "restart":
                event.getAuthor().openPrivateChannel().complete().sendMessage(":white_check_mark: Reiniciando o bot... :white_check_mark:").queue();
                break;
            default:
                event.getAuthor().openPrivateChannel().complete().sendMessage(":x: Oops... Você precisa inserir algum argumento para utilizar esse comando... :x:").queue();
                break;
        }
    }

    @Override
    public void executed(boolean sucessful, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
