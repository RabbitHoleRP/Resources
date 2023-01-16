package br.com.rabbithole.resources;

import br.com.rabbithole.resources.commands.admin.ScamCommand;
import br.com.rabbithole.resources.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Resources extends JavaPlugin {
    public static ResourcesAPI API;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<green>Resources iniciado com Sucesso!"));
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<green>Bukkit.getVersion() : " + Bukkit.getVersion()));
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<green>Bukkit.getServer().getVersion() : " + Bukkit.getServer().getVersion()));
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<green>Bukkit.getServer().getMinecraftVersion() : "+ Bukkit.getServer().getMinecraftVersion()));
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<green>Bukkit.getServer().getBukkitVersion() : " + Bukkit.getServer().getBukkitVersion()));
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<green>Versão Convertida : " + getServerVersion()));
        registers();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(StringUtils.format("<red>Resources  desativado com Sucesso!"));
    }

    void registers() {
        commands();
        API = new ResourcesAPI();
    }

    void commands() {
        new ScamCommand(this);
    }

    public static ResourcesAPI getAPI() {
        return API;
    }

    public static int getServerVersion() {
        return Integer.parseInt(Bukkit.getServer().getMinecraftVersion().replace(".", ""));
    }
}
