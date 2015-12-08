import java.awt.Color;
import java.awt.Graphics;

/**
 * <p>Class Box </p>
 * <p>A box is a rectangle that may contain another box </p>
 * @author CSC 143
 */

public class Box {

  // Dimensions and location
  private int height, width, centerX, centerY;
  // Color
  private Color color;

  // Box inside of this box
  private Box innerBox;

  /**
   * Creates a box of a given width, height, location and color.
   * @param centerX the x coordinate of the center of the box.
   * @param centerY the y coordinate of the center of the box.
   * @param width the width of the box.
   * @param height the height of the box.
   * @param color the color of the box.
   * @throws InvalidArgumentException if width or height are not positive, or
   * if color is null.
   */
  public Box(int centerX, int centerY, int height, int width, Color color) {
    if (height <= 0) {
      throw new IllegalArgumentException("Height is not positive");
    }
    if (width <= 0) {
      throw new IllegalArgumentException("Width is not positive");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color is null");
    }

    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
    this.height = height;
    this.width = width;
  }

  /**
   * Adds an inner box to this box. Returns true if the operation was
   * successful and false otherwise. The inner box might not be added if its
   * dimensions are less than or equal to 1.
   * The inner box has the same center and is 10% smaller than its direct
   * enclosing box. The inner box has the same color as its enclosing box.
   * @return true if the inner box could be added and false otherwise.
   */
  public boolean addInnerBox() {
    // Base case: there is no inner box, create one.
    if (innerBox == null) {
      int width = (int) (this.width * 0.9);
      int height = (int) (this.height * 0.9);
      if (width >= 2 && height >= 2) {
        innerBox = new Box(centerX, centerY, height, width, color);
        return true;
      }
      else {
        return false;
      }
    }
    // Add an inner box the inner box
    else {
      return innerBox.addInnerBox();
    }
  }

  /**
   * Gets the number of inner boxes inside this box
   */
  public int getNumberOfInnerBoxes() {
    // Base case: no inner box
    if (innerBox == null) {
      return 0;
    }
    else {
      return 1 + innerBox.getNumberOfInnerBoxes();
    }
  }


  /**
   * Draws this box (and its inner boxes if any)
   * @param g the graphics context to use
   */
  public void draw(Graphics g) {
    // Draw this box
    g.setColor(color);
    g.drawRect(centerX - width / 2, centerY - height / 2, width, height);
    // Draw the inner box
    if (innerBox != null) {
      innerBox.draw(g);
    }
  }

  /**
   * Returns a string representation of this box, namely the location of its
   * center, its width and height, its color and its number of inner boxes.
   * @return a string representation of this box.
   */
  public String toString() {
    return "centerX = " + centerX + "  centerY = " + centerY + "  width = " + width +
        "  height = " + height + "  color = " + color + "  Number of inner boxes = " +
        getNumberOfInnerBoxes();
  }
}



















