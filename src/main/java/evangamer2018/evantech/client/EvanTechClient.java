package evangamer2018.evantech.client;

import evangamer2018.evantech.gui.ModGUIs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class EvanTechClient implements ClientModInitializer {
    public void onInitializeClient() {
        ModGUIs.registerClientGUIs();
    }
}
