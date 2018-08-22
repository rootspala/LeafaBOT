package me.roots.leafa.command.managers;

import me.roots.leafa.utils.BotClass;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandHandler extends ListenerAdapter {

    public static List<LeafaCommand> registeredCmd;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().startsWith(BotClass.PREFIX)) {
            List<String> commandBody = new ArrayList<>(Arrays.asList(event.getMessage().getContentDisplay().replace(BotClass.PREFIX,
                    "").split(" ")));

            List<LeafaCommand> correspondingCmds = registeredCmd.stream()
                    .filter(cmd -> cmd.getName().equalsIgnoreCase(commandBody.get(0)))
                    .collect(Collectors.toList());

            if (correspondingCmds.isEmpty()) {
                return;
            }

            LeafaCommand command = registeredCmd.get(0);

            //TODO aqui você faz a verificação de permissão, abaixo está um exemplo de como fazer

            commandBody.remove(0);
            command.run(event, commandBody.toArray(new String[commandBody.size()]));
        }
    }

    public static void add(LeafaCommand cmd) {
        registeredCmd.add(cmd);
    }

}
