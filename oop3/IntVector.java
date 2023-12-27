import java.util.List;

/**
 * @author Lawrence Li
 */
public class IntVector {

  private int capacity;
  private int size;
  private int[] a;

  private final StringBuilder sb = new StringBuilder();

  /**
   * Copies the first n values from src to dest
   *
   * @param src  source array (assumed to be large enough)
   * @param dest destination array (assumed to be large enough)
   * @param n    how many values to copy
   * @return destination array
   */
  public static int[] copyTo(int[] src, int[] dest, int n) {
    for (int i = 0; i < n; i++) {
      dest[i] = src[i];
    }
    return dest;
  }

  /**
   * Computes new capacity when adding to the size: if enough capacity, return the
   * current capacity; otherwise repeatedly double the capacity until enough (if
   * capacity is 0, "doubling" it results in 1)
   *
   * @param capacity current capacity
   * @param size     current size
   * @param toAdd    elements to add
   * @return new capacity
   */
  public static int doubleIfNeeded(int capacity, int size, int toAdd) {
    final int newSize = size + toAdd;
    while (capacity < newSize) {
      if (capacity == 0) {
        capacity = 1;
      } else {
        capacity *= 2;
      }
    }

    return capacity;
  }

  /**
   * Initialize with capacity=10, size=0
   */
  public IntVector() {
    this(10);
  }

  /**
   * Initialize with size=0 and the supplied initial capacity (0 if negative)
   *
   * @param initCapacity initial capacity
   */
  public IntVector(int initCapacity) {
    size = 0;
    if (initCapacity > 0) {
      capacity = initCapacity;
      a = new int[initCapacity];
    } else {
      capacity = 0;
      a = null;
    }
  }

  /**
   * Initialize with provided initial size, all of which have the same initial
   * value. Capacity should be same as size. (0 if supplied invalid size.)
   *
   * @param initSize  initial size
   * @param initValue initial value of all elements
   */
  public IntVector(int initSize, int initValue) {
    if (initSize < 0) {
      initSize = 0;
    }

    size = capacity = initSize;
    if (capacity > 0) {
      a = new int[capacity];
      for (int i = 0; i < capacity; i++) {
        a[i] = initValue;
      }
    } else {
      a = null;
    }
  }

  /**
   * Initializes the size, capacity, and values via a source array (0 if null)
   *
   * @param source initial contents
   */
  public IntVector(int[] source) {
    if (source == null) {
      source = new int[] {};
    }

    size = capacity = source.length;
    if (size > 0) {
      a = copyTo(source, new int[size], size);
    } else {
      a = null;
    }
  }

  /**
   * [e_0, e_1, ... e_size]
   *
   * @return string representation
   */
  @Override
  public String toString() {
    sb.setLength(0);
    sb.append("[");
    if (a != null && size > 0) {
      sb.append(String.valueOf(a[0]));
      for (int i = 1; i < size; i++) {
        sb.append(String.format(", %d", a[i]));
      }
    }
    sb.append("]");

    return sb.toString();
  }

  /**
   * Returns true if supplied object is also an IntVector and has the same
   * size/contents (independent of capacity)
   *
   * @param o other object
   * @return true if same contents
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof IntVector) {
      final IntVector v = (IntVector) o;
      if (size == v.size) {
        for (int i = 0; i < size; i++) {
          if (a[i] != v.a[i]) {
            return false;
          }
        }
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private boolean _validIndex(int index, boolean allowEnd) {
    if (!allowEnd) {
      return (index >= 0 && index < size);
    } else {
      return (index >= 0 && index <= size);
    }
  }

  /**
   * Returns true if supplied index is valid: 0 <= index < size
   *
   * @param index index to check
   * @return true if valid index
   */
  public boolean validIndex(int index) {
    return _validIndex(index, false);
  }

  /**
   * Gets the current size
   *
   * @return current size
   */
  public int getSize() {
    return size;
  }

  /**
   * Returns true if empty
   *
   * @return true if size is 0
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns current capacity
   *
   * @return current capacity
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Gets the element at supplied index, null if invalid index
   *
   * @param index desired index
   * @return corresponding element, null if invalid index
   */
  public Integer get(int index) {
    if (validIndex(index)) {
      return a[index];
    } else {
      return null;
    }
  }

  /**
   * Returns an array with the current contents
   *
   * @return array with current elements
   */
  public int[] toArray() {
    return copyTo(a, new int[size], size);
  }

  /**
   * Changes the value of an element
   *
   * @param index index to change
   * @param value value to set
   * @return new value, null if invalid index
   */
  public Integer set(int index, int value) {
    if (validIndex(index)) {
      return a[index] = value;
    } else {
      return null;
    }
  }

  /**
   * Reverses the contents
   *
   * [1, 2, 3] => [3, 2, 1]
   */
  public void reverse() {
    for (int i = 0; i < (size / 2); i++) {
      final int temp = a[i];
      final int oppIndex = (size - i - 1);

      a[i] = a[oppIndex];
      a[oppIndex] = temp;
    }
  }

  /**
   * Makes sure there is room for at least n elements. If greater than current
   * capacity, n becomes the new capacity.
   *
   * @param n desired minimum capacity
   */
  public void ensureCapacity(int n) {
    if (n > capacity) {
      if (a == null) {
        a = new int[n];
      } else {
        a = copyTo(a, new int[n], size);
      }
      capacity = a.length;
    }
  }

  /**
   * Adds an element to the end.
   *
   * Capacity should increase according to the doubling policy (see
   * doubleIfNeeded).
   *
   * @param value value to add
   * @return value added
   */
  public int add(int value) {
    ensureCapacity(doubleIfNeeded(capacity, size, 1));
    return (a[size++] = value);
  }

  /**
   * Add a value at a supplied index. If not the end, all values from the index
   * are shifted right.
   *
   * Capacity should increase according to the doubling policy (see
   * doubleIfNeeded).
   *
   * If invalid index, no change is made.
   *
   * @param index index at which to insert
   * @param value value to insert
   * @return value added, null if invalid index
   */
  public Integer add(int index, int value) {
    if (!_validIndex(index, true)) {
      return null;
    }

    ensureCapacity(doubleIfNeeded(capacity, size, 1));
    size++;

    for (int i = (size - 1); i > index; i--) {
      a[i] = a[i - 1];
    }
    a[index] = value;

    return value;
  }

  /**
   * Add a list of values to the end.
   *
   * Capacity should increase according to the doubling policy (see
   * doubleIfNeeded).
   *
   * @param values list of values to add in order
   */
  public void addAll(List<Integer> values) {
    ensureCapacity(doubleIfNeeded(capacity, size, values.size()));
    for (int v : values) {
      a[size++] = v;
    }
  }

  /**
   * Add a list of values at a supplied index. If not the end, all values from
   * index are shifted right.
   *
   * Capacity should increase according to the doubling policy (see
   * doubleIfNeeded).
   *
   * If invalid index, no change is made.
   *
   * @param index
   * @param values
   */
  public void addAll(int index, List<Integer> values) {
    if (_validIndex(index, true)) {
      final int numToAdd = values.size();

      ensureCapacity(doubleIfNeeded(capacity, size, numToAdd));
      size += values.size();

      for (int i = (size - 1); i > (index + numToAdd - 1); i--) {
        a[i] = a[i - numToAdd];
      }

      for (int i = 0; i < numToAdd; i++) {
        a[index + i] = values.get(i);
      }
    }
  }

  /**
   * Sets the size to 0 without changing capacity.
   */
  public void clear() {
    size = 0;
  }

  /**
   * Reduces the capacity to the current size
   */
  public void trimToSize() {
    if (capacity != size) {
      if (size == 0) {
        a = null;
      } else {
        a = copyTo(a, new int[size], size);
      }
      capacity = size;
    }
  }

  /**
   * Remove the last element in the list
   *
   * @return removed element, null if was empty
   */
  public Integer removeLast() {
    if (size > 0) {
      return a[--size];
    } else {
      return null;
    }
  }

  /**
   * Remove element at supplied index. All elements after are shifted left.
   *
   * @param index index to remove
   * @return removed value, null if invalid index
   */
  public Integer remove(int index) {
    if (validIndex(index)) {
      final int value = a[index];
      for (int i = index; i < (size - 1); i++) {
        a[i] = a[i + 1];
      }
      size--;

      return value;
    } else {
      return null;
    }
  }

  /**
   * Removes the first element that has the supplied value.
   *
   * @param value value to remove
   * @return value, null if not found
   */
  public Integer removeFirst(int value) {
    for (int i = 0; i < size; i++) {
      if (a[i] == value) {
        return remove(i);
      }
    }

    return null;
  }

  /**
   * Removes all elements that pass a supplied test
   *
   * @param p test to apply to each element
   * @return number of elements removed
   */
  public int removeAllIf(IntTester p) {
    final boolean[] b = new boolean[size];

    int count = 0;
    for (int i = 0; i < size; i++) {
      if (p.test(i, a[i])) {
        b[i] = true;
        count++;
      }
    }

    int removed = 0;
    for (int i = 0; i < b.length; i++) {
      if (b[i]) {
        remove(i - (removed++));
      }
    }

    return count;
  }

  /**
   * Removes all elements of a particular value.
   *
   * @param value value to remove
   * @return number of elements removed
   */
  public int removeAll(int value) {
    return removeAllIf((i, v) -> v == value);
  }
}
