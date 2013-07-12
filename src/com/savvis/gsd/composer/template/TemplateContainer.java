package com.savvis.gsd.composer.template;

import java.util.ArrayList;
import java.util.Collection;

import com.vaadin.data.Container.Hierarchical;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;

public class TemplateContainer {
    public static HierarchicalContainer createTreeContent() {
        final Object[] inventory = new Object[] {
                "root",
                "+5 Quarterstaff (blessed)",
                "+3 Elven Dagger (blessed)",
                "+5 Helmet (greased)",
                new Object[] {"Sack",
                        "Pick-Axe",
                        "Lock Pick",
                        "Tinning Kit",
                        "Potion of Healing (blessed)",
                },
                new Object[] {"Bag of Holding",
                        "Potion of Invisibility",
                        "Magic Marker",
                        "Can of Grease (blessed)",
                },
                new Object[] {"Chest",
                        "Scroll of Identify",
                        "Scroll of Genocide",
                        "Towel",
                        new Object[] {"Large Box",
                                "Bugle",
                                "Oil Lamp",
                                "Figurine of Vaadin",
                                "Expensive Camera",
                        },
                        "Tin Opener",
                },
        };

        HierarchicalContainer container = new HierarchicalContainer();
        
        // A property that holds the caption is needed for ITEM_CAPTION_MODE_PROPERTY
        container.addContainerProperty("caption", String.class, "");
        
        new Object() {
            public void put(Object[] data, Object parent, HierarchicalContainer container) {
                for (int i=1; i<data.length; i++) {
                    if (data[i].getClass() == String.class) {
                        // Support both ITEM_CAPTION_MODE_ID and ITEM_CAPTION_MODE_PROPERTY
                        container.addItem(data[i]);
                        container.getItem(data[i]).getItemProperty("caption").setValue(data[i]);
                        container.setParent(data[i], parent);
                        container.setChildrenAllowed(data[i], false);
                    } else {// It's an Object[]
                        Object[] sub = (Object[]) data[i];
                        String name = (String) sub[0];

                        // Support both ITEM_CAPTION_MODE_ID and ITEM_CAPTION_MODE_PROPERTY
                        container.addItem(name);
                        container.getItem(name).getItemProperty("caption").setValue(name);
                        put(sub, name, container);
                        container.setParent(name, parent);
                    }
                }
            }
        }.put(inventory, null, container);
        
        return container;
    }
}
