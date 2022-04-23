package edu.mod.mod_mhps.client.render;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import edu.mod.mod_mhps.client.render.model.DieModel;
import edu.mod.mod_mhps.common.entity.DieBall;

public class DieBallRender<Type extends DieBall> extends MobRenderer<Type, DieModel<Type>> {

    public DieBallRender(Context context) {
            super(context, new DieModel<>(context.bakeLayer(DieModel.LAYER_LOCATION)), 0.5f);
    }
    
    private static final ResourceLocation TEXTURE = new ResourceLocation("mod_mhps", "textures/entities/die_ball.png");

    

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
    
}
