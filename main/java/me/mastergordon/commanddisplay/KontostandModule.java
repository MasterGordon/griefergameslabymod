package me.mastergordon.commanddisplay;

import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement.IconData;

public class KontostandModule extends SimpleModule{

	@Override
	public String getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "Kontostand";
	}

	@Override
	public String getDisplayValue() {
		// TODO Auto-generated method stub
		return Main.kontoStand;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IconData getIconData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSettingName() {
		// TODO Auto-generated method stub
		return "Kontostand";
	}

	@Override
	public int getSortingId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void loadSettings() {
		// TODO Auto-generated method stub
		
	}

}
