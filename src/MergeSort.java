import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    //  Sort by Name (Alphabetical A → Z)

    public List<Medicine> mergeSortByName(List<Medicine> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Medicine> left  = mergeSortByName(new ArrayList<>(list.subList(0, mid)));
        List<Medicine> right = mergeSortByName(new ArrayList<>(list.subList(mid, list.size())));

        return mergeByName(left, right);
    }

    private List<Medicine> mergeByName(List<Medicine> left, List<Medicine> right) {
        List<Medicine> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMedicineName()
                    .compareToIgnoreCase(right.get(j).getMedicineName()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size())  result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }


    //  Sort by Price (Low → High)

    public List<Medicine> mergeSortByPrice(List<Medicine> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Medicine> left  = mergeSortByPrice(new ArrayList<>(list.subList(0, mid)));
        List<Medicine> right = mergeSortByPrice(new ArrayList<>(list.subList(mid, list.size())));

        return mergeByPrice(left, right);
    }

    private List<Medicine> mergeByPrice(List<Medicine> left, List<Medicine> right) {
        List<Medicine> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getPrice() <= right.get(j).getPrice()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size())  result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }


    //  Sort by Quantity (Low → High)

    public List<Medicine> mergeSortByQuantity(List<Medicine> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Medicine> left  = mergeSortByQuantity(new ArrayList<>(list.subList(0, mid)));
        List<Medicine> right = mergeSortByQuantity(new ArrayList<>(list.subList(mid, list.size())));

        return mergeByQuantity(left, right);
    }

    private List<Medicine> mergeByQuantity(List<Medicine> left, List<Medicine> right) {
        List<Medicine> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getQuantity() <= right.get(j).getQuantity()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size())  result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }
}