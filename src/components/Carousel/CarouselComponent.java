package components.Carousel;

import java.util.List;

import components.ItemComponent;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class CarouselComponent extends AnchorPane {

    private ICarouselList carouselList;

    private HBox itemsContainer;

    private ImageView next;
    private ImageView prev;

    public CarouselComponent(List<ItemComponent> list) {
        // Create instances
        this.carouselList = new CarouselList(list);
        this.itemsContainer = new HBox();
        this.next = new ImageView("./images/carousel/next.png");
        this.prev = new ImageView("./images/carousel/back.png");

        addStyles();
        setEvents();
        initializeCarousel();

        this.getChildren().addAll(itemsContainer, prev, next);

    }

    private void initializeCarousel() {
        for (ItemComponent item : carouselList.getActiveItems()) {
            itemsContainer.getChildren().add(item);
        }
    }

    private void updateCarousel() {
        itemsContainer.getChildren().clear();
        for (ItemComponent item : carouselList.getActiveItems()) {
            itemsContainer.getChildren().add(item);
        }
    }

    /*
     * private void handleClickMe(MouseEvent event) {
     * System.out.println(itemsContainer); carouselList.nextItem();
     * 
     * updateCarousel(); }
     */

    private void setEvents() {
        // next.setOnMouseClicked(this::handleClickMe);

        EventHandler<MouseEvent> nextEvent = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (carouselList.nextItem() != null)
                    updateCarousel();
            }
        };

        EventHandler<MouseEvent> prevEvent = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (carouselList.prevItem() != null)
                    updateCarousel();
            }
        };

        next.onMouseClickedProperty().set(nextEvent);
        prev.onMouseClickedProperty().set(prevEvent);
    }

    private void addStyles() {
        itemsContainer.setSpacing(10);

        this.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        prev.setFitHeight(30);
        prev.setFitWidth(30);
        next.setFitHeight(30);
        next.setFitWidth(30);

        prev.getStyleClass().add("arrow");
        next.getStyleClass().add("arrow");

        AnchorPane.setLeftAnchor(prev, 5.0);
        AnchorPane.setRightAnchor(next, 5.0);
        AnchorPane.setTopAnchor(prev, 140.0);
        AnchorPane.setTopAnchor(next, 140.0);

    }
}
