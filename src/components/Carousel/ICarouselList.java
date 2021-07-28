package components.Carousel;

import java.util.Deque;

import components.ItemComponent;

public interface ICarouselList {
    public ItemComponent nextItem();

    public ItemComponent prevItem();

    public Deque<ItemComponent> getActiveItems();
}
