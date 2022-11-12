package sirjain.throwable_fluids.entity.other;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormEntity;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormModel;
import sirjain.throwable_fluids.entity.glow_worm.GlowWormRenderer;
import sirjain.throwable_fluids.entity.splasher.SplasherEntity;
import sirjain.throwable_fluids.entity.splasher.SplasherModel;
import sirjain.throwable_fluids.entity.splasher.SplasherRenderer;
import sirjain.throwable_fluids.main.ThrowableFluids;

public class ModEntityTypes {
    public static final EntityModelLayer SPLASHER_LAYER = new EntityModelLayer(new Identifier(ThrowableFluids.MOD_ID, "splasher"), "root");
    public static final EntityType<SplasherEntity> SPLASHER_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableFluids.MOD_ID, "splasher"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SplasherEntity::new).dimensions(EntityDimensions.fixed(1.25f, 2f)).build()
    );

    public static final EntityModelLayer GLOW_WORM_LAYER = new EntityModelLayer(new Identifier(ThrowableFluids.MOD_ID, "glow_worm"), "root");
    public static final EntityType<GlowWormEntity> GLOW_WORM_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ThrowableFluids.MOD_ID, "glow_worm"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GlowWormEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntityTypes.SPLASHER_ENTITY, SplasherEntity.createSplasherAttributes());
        FabricDefaultAttributeRegistry.register(ModEntityTypes.GLOW_WORM_ENTITY, GlowWormEntity.createGlowWormAttributes());
    }

    public static void registerEntityRender() {
        EntityRendererRegistry.register(ModEntityTypes.SPLASHER_ENTITY, SplasherRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SPLASHER_LAYER, SplasherModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntityTypes.GLOW_WORM_ENTITY, GlowWormRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GLOW_WORM_LAYER, GlowWormModel::getTexturedModelData);
    }
}
