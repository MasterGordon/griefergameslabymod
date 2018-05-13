package me.mastergordon.commanddisplay;

import java.util.List;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class Main extends LabyModAddon {

	boolean isOnServer = false;
	int tick = 0;
	boolean waitingForResponse = false;
	public static String kontoStand = "$0";

	@Override
	protected void fillSettings(List<SettingsElement> subSettings) {

	}

	@Override
	public void loadConfig() {

	}

	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {
		System.out.println("Enable Command Display");
		getApi().registerForgeListener(this);
		getApi().getEventManager().registerOnJoin(new Consumer<ServerData>() {
			@Override
			public void accept(ServerData arg0) {
				if (arg0.getIp().equalsIgnoreCase("griefergames.net"))
					isOnServer = true;
			}
		});
		getApi().getEventManager().registerOnQuit(new Consumer<ServerData>() {
			@Override
			public void accept(ServerData arg0) {
				isOnServer = false;
			}
		});
		getApi().getEventManager().register(new MessageReceiveEvent() {

			@Override
			public boolean onReceive(String arg0, String arg1) {
				System.out.println(arg0);
				if (waitingForResponse && arg0.contains("Kontostand")) {
					kontoStand = arg0.substring(20);
					waitingForResponse = false;
					return true;
				}
				return false;
			}
		});
		getApi().registerModule(new KontostandModule());
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (isOnServer) {
			if (tick % 200 == 0) {
				tick = 0;
				Minecraft.getMinecraft().thePlayer.sendChatMessage("/money");
				waitingForResponse = true;
			}
			tick++;
		}
	}
}
