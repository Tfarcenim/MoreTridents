package tfar.moretridents.datagen.assets;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.SeparateTransformsModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.moretridents.MoreTridents;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.init.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, MoreTridents.MOD_ID, existingFileHelper);
    }

    //   private static final ModelResourceLocation TRIDENT_MODEL = ModelResourceLocation.vanilla("trident", "inventory");
    //   public static final ModelResourceLocation TRIDENT_IN_HAND_MODEL = ModelResourceLocation.vanilla("trident_in_hand", "inventory");

    @Override
    protected void registerModels() {
    //    makeSpriteModel("rudimentary_gauntlet");
      //  makeSpriteModel("netherite_gauntlet");

       // pDisplayContext == ItemDisplayContext.GUI || pDisplayContext == ItemDisplayContext.GROUND || pDisplayContext == ItemDisplayContext.FIXED;

        trident(ModItems.WOODEN_TRIDENT);

    }

    protected ItemModelBuilder makeSpriteModel(String name) {
        return getBuilder("item/perspective/gui/" + name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/perspective/gui/" + name);

    }

    private void trident(TieredTridentItem tieredTridentItem) {

        String name = BuiltInRegistries.ITEM.getKey(tieredTridentItem).getPath();

        //trident in hand model
        ItemModelBuilder r3dFile = nested()
                .parent(getExistingFile(modLoc("item/base_trident_in_hand")));

        ItemModelBuilder rSpriteFile = makeSpriteModel(name);

        getBuilder(name).guiLight(BlockModel.GuiLight.FRONT)
                .customLoader(SeparateTransformsModelBuilder::begin).base(rSpriteFile)
                .perspective(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, r3dFile)
                .perspective(ItemDisplayContext.FIRST_PERSON_LEFT_HAND, r3dFile)
                .perspective(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, r3dFile)
                .perspective(ItemDisplayContext.THIRD_PERSON_LEFT_HAND, r3dFile)
                .end();
    }


    protected void makeOneLayerItem(Item item, ResourceLocation texture) {
        String path = BuiltInRegistries.ITEM.getKey(item).getPath();
        if (existingFileHelper.exists(new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath())
                , PackType.CLIENT_RESOURCES, ".png", "textures")) {
            getBuilder(path).parent(getExistingFile(mcLoc("item/generated")))
                    .texture("layer0", new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath()));
        } else {
            System.out.println("no texture for " + item + " found, skipping");
        }
    }

    protected void makeOneLayerItem(Item item) {
        ResourceLocation texture = BuiltInRegistries.ITEM.getKey(item);
        makeOneLayerItem(item, texture);
    }
}
