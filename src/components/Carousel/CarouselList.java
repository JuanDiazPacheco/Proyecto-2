package components.Carousel;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import components.ItemComponent;

public class CarouselList implements ICarouselList {
    private List<ItemComponent> itemsList;
    private Deque<ItemComponent> activeItems;

    private int numberItems = 4;
    private int firstItemActive;
    private int lastItemActive;

    public CarouselList(List<ItemComponent> list) {
        this.itemsList = list;
        activeItems = new LinkedList<>();

        initialize();
    }

    private void initialize() {
        firstItemActive = 0;
        lastItemActive = firstItemActive;

        for (ItemComponent item : itemsList) {

            if (lastItemActive < numberItems) {
                activeItems.add(item);
                lastItemActive++;
            } else
                break;

        }
    }

    /**
     * @return Deque<ItemComponent>
     */
    @Override
    public Deque<ItemComponent> getActiveItems() {
        return this.activeItems;
    }

    /**
     * @return ItemComponent
     */
    @Override
    public ItemComponent nextItem() {

        if (lastItemActive > itemsList.size() - 1) {
            return null;
        }

        activeItems.removeFirst();
        activeItems.addLast(itemsList.get(lastItemActive));

        firstItemActive++;
        lastItemActive++;

        return activeItems.getLast();
    }

    /**
     * @return ItemComponent
     */
    @Override
    public ItemComponent prevItem() {
        if (firstItemActive <= 0) {
            return null;
        }

        firstItemActive--;
        lastItemActive--;

        activeItems.removeLast();
        activeItems.addFirst(itemsList.get(firstItemActive));

        return activeItems.getFirst();
    }
}
