package tfar.moretridents.datagen.assets;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;
import tfar.moretridents.MoreTridents;
import tfar.moretridents.datagen.ModDatagen;

import java.util.function.Supplier;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput gen) {
        super(gen, MoreTridents.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ModDatagen.getKnownItems().forEach(item -> {
            if (!(item instanceof BlockItem)) {
                addDefaultItem(() -> item);
            }
        });
    }
    protected void addGroup(CreativeModeTab group,String name) {
        add(group.getDisplayName().getString(),name);
    }

    protected void addDefaultItem(Supplier<? extends Item> supplier) {
        addItem(supplier,getNameFromItem(supplier.get()));
    }

    public static String getNameFromItem(Item item) {
        return StringUtils.capitaliseAllWords(item.getDescriptionId().split("\\.")[2].replace("_", " "));
    }
}
