package com.skitbet.zephyr;

import com.skitbet.zephyr.command.CommandHandler;
import com.skitbet.zephyr.utils.Tokens;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class ZephyrBot {

    public static ZephyrBot INSTANCE;
    private final JDA jda;

    private CommandHandler commandHandler;

    public boolean ready;

    public ZephyrBot() {
        INSTANCE = this;
        JDABuilder builder = JDABuilder.create(Tokens.TOKEN, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES);

        this.jda = builder.build();


        this.commandHandler = new CommandHandler(this.jda.updateCommands());
        this.commandHandler.registerCommands();
        this.jda.addEventListener(this.commandHandler);

    }

    public JDA getJda() {
        return jda;
    }
}
