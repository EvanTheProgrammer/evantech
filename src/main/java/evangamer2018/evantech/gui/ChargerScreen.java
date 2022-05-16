package evangamer2018.evantech.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import evangamer2018.evantech.EvanTech;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ChargerScreen extends HandledScreen<ChargerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(EvanTech.MOD_ID, "textures/gui/machine/charger.png");
    ChargerScreenHandler screenHandler;
    public ChargerScreen(ChargerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.screenHandler = handler;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        drawTexture(matrices, x, y, 0, 0, 175, 165);

        if(screenHandler.getEnergy() != 0){
            int k = (screenHandler.getEnergy() * 40 / screenHandler.getEnergyCap());
            this.drawTexture(matrices, x + 17, y + 23 + 40 - k, 176, 40 - k, 16, k);
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
