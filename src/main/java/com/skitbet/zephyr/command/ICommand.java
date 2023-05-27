/*
 * @author skeet
 * Created At: 4/28/22, 9:31 AM
 * Project: Copper
 */

package com.skitbet.zephyr.command;

import com.skitbet.zephyr.ZephyrBot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.util.List;

public abstract class ICommand {

    public final String name;
    public final String description;

    public ICommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected ZephyrBot zephyrBot = ZephyrBot.INSTANCE;

    public abstract void run(SlashCommandInteractionEvent event);

    public List<OptionData> getOptions() {
        return null;
    }
    public List<SubcommandData> getSubCommands() {
        return null;
    }
    public List<Permission> getRequiredPermissions() {
        return null;
    }

}
