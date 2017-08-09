package Coding_Problems;

//Finding no of key along with position of the first and last key in an array

/*The problem here is to find the no of keys(single key)in a particular array along with its first position and the
last position of the key(the array is a sorted array with repeated elements in the array)*/

//The solution of this problem is slight modification of binary search

public class BinarySearchFindKey {


    //Method to find the first position of a key in the array
    private int firstKeyPos(int[] arr,int len,int key){
        int low  = 0;
        int high = len - 1;
        int mid;
        int result = -1;
        while(low <= high){
            mid = low + ((high - low)/2);
            if(arr[mid] == key){
                result = mid;          //storing the current position of element key and reducing the search space
                high = mid - 1;        // to the left to find any more key to the left of the current key position
            }
            else if(key < arr[mid]) {
                high = mid - 1;
            }
            else if(key > arr[mid]) {
                low = mid + 1;
            }
        }
        return result;
    }


    //Method to find the last position of a key in the array
    private int lastKeyPos(int[] arr, int len, int key){
        int low = 0;
        int high = len - 1;
        int result = -1;
        int mid;
        while(low <= high){
            mid = low + ((high-low)/2);
            if(arr[mid] == key){
                result = mid;           //storing the current position of element key and reducing the search space
                low = mid + 1;          // to the right to find any more key to the right of the current key position
            }
            else if(key < arr[mid]){
                high = mid -1;
            }
            else if(key > arr[mid]){
                low = mid + 1;
            }
        }
        return result;
    }


    //Combining the above two method to find the first and last key as their is a just the difference of one line
    private int firstAndLastKeyPos(int[] arr, int len, int key, boolean firstKey){
        int low  = 0;
        int high = len - 1;
        int mid;
        int result = -1;
        while(low <= high){
            mid = low + ((high - low)/2);
            if(arr[mid] == key){
                result = mid;
                if(firstKey == true)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else if(key < arr[mid]) {
                high = mid - 1;
            }
            else if(key > arr[mid]) {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchFindKey obj = new BinarySearchFindKey();
        int[] arr = new int[]{10, 10, 20, 30, 40, 40, 40, 40, 50, 60, 60};
        int len = arr.length;


        int key = 40;
        System.out.println("Calculating using separate method for first and last position\n");
        int firstPos = obj.firstKeyPos(arr, len, key);
        if (firstPos == -1) {
            System.out.println("The Key " + key + " not found in the list");
        }
        else {
            System.out.println("The key " + key + " is found initially at position : " + firstPos);
        }
        int lastPos = obj.lastKeyPos(arr,len,key);
        if (lastPos == -1) {
            System.out.println("The Key " + key + " not found in the list");
        }
        else {
            System.out.println("The key " + key + " is found lastly at position : " + lastPos);
        }
        int noOfKey = lastPos - firstPos + 1;   //Calculating total no of keys
        System.out.println("Total no of "+key+"'s in array : "+noOfKey);




        key = 60;
        System.out.println("\nCalculating using one method(firstAndLastKeyPos())\n");
        firstPos = obj.firstAndLastKeyPos(arr,len,key,true);
        lastPos = obj.firstAndLastKeyPos(arr,len,key,false);
        if (firstPos == -1) {
            System.out.println("The Key " + key + " not found in the list");
        }
        else {
            System.out.println("The key " + key + " is found initially at position : " + firstPos);
        }
        if (lastPos == -1) {
            System.out.println("The Key " + key + " not found in the list");
        }
        else {
            System.out.println("The key " + key + " is found lastly at position : " + lastPos);
        }
        noOfKey = lastPos - firstPos + 1;
        System.out.println("Total no of "+key+"'s in array : "+noOfKey);
    }
}
// Array used: {10, 10, 20, 30, 40, 40, 40, 40, 50, 60, 60}
/*Output:
Calculating using separate method for first and last position

The key 40 is found initially at position : 4
The key 40 is found lastly at position : 7
Total no of 40's in array : 4

Calculating using one method(firstAndLastKeyPos())

The key 60 is found initially at position : 9
The key 60 is found lastly at position : 10
Total no of 60's in array : 2

 */
