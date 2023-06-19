/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btnc;

/**
 *
 * @author ntn19
 */
public class Bai_1 {
    
    public static int[] findSubArray(int[] arr, int k){
    //Số lượng phần tử trong mảng
    int n = arr.length;
    
    // Kiểm tra trường hợp đặc biệt
    if (k <= 0 || n < k) {
        return new int[0];
        //không tồn tại mảng thỏa mãn điều kiện nên trả về 1 mảng rỗng và thoát
    }
    
    int minSum = 0;
    int minStart = 0;
    
    // Tính tổng k phần tử liên tiếp đầu tiên
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += arr[i];
    }
    
    minSum = sum;
    
    // Tìm tổng k phần tử liên tiếp có tổng nhỏ nhất
    for (int i = k; i < n; i++) {
        sum += arr[i] - arr[i - k];//Cộng với số đuôi rồi trừ đi số đầu
        if (sum < minSum) { // nếu tổng k số sau nhỏ tổng k số trước
            minSum = sum; // đổi lại minsum
            minStart = i - k + 1; // lấy vị trí đầu của k số đó trong mảng arr
        }
    }
    
    // Sao chép mảng con có tổng nhỏ nhất vào một mảng mới
    int[] subArray = new int[k];
    System.arraycopy(arr, minStart, subArray, 0, k);
    // copy k số từ mảng arr vào mảng subArray bắt đầu từ minstast đến k của arr vào vị trí số 0 của subArray;
    
    return subArray;
}
    public static int equalSum(int[] arr){
        //Chia mảng thành 2 phần. tổng số đầu và tổng số cuối.
        //nếu tổng số đầu nhỏ hơn tổng số cuối thì tổng số đầu cộng thêm tổng số cuối trừ đi.
        //đến khi nó bằng nhau thì đưa ra vị trí. nếu nó không bằng nhau tổng số đầu sẽ lớ hơn tổng số cuối thì trả về -1
        int n = arr.length;
        if(n < 3){
            return -1;
        }
        
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = arr[0];
        int leftIndext = 1;
        int rightSum = totalSum - leftSum - arr[leftIndext];
        
        while (leftSum <= rightSum) {            
            if(leftSum < rightSum){
                leftSum += arr[leftIndext];
                rightSum = totalSum - leftSum - arr[leftIndext+1];
                leftIndext++;
            }else if(leftSum == rightSum){
                return leftIndext;
            }
        }
        return -1;
    }
    
    public static int majorityFrequent(int[] arr) {
    int n = arr.length;
    if (n == 0) {
        return -1;  // Mảng rỗng
    }
    
    int count = 0;
    int candidate = arr[0];
    // Câu lệnh for này giúp tìm số xuất hiện nhiều hơn size/2.
    //Nhưng nó chỉ đúng khi có tồn tại số đó. nếu không tồn tại nó sẽ đưa ra số ở vị trí cuối mảng
    for (int i = 0; i < n; i++) {
        if (count == 0) {
            candidate = arr[i];
            count = 1;
        } else if (arr[i] == candidate) {
            count++;
        } else {
            count--;
        }
    }
    
    //Kiểm tra xem candidate có phải số quan trọng.
    int s = 0;
    for(int i = 0; i < n; i++){
        if (arr[i] == candidate) {
            s++;
        }
    }
    //Nếu đúng là số quan trọng tìm vị trí nhỏ nhất của số quan trọng
    if(s > n/2){
        for(int i = 0; i < n; i++){
            if(arr[i] == candidate){
                return i;
            }
        }
    }
    return  -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 0, 3, 3, 1, 1};
        int k = 2;
        
        //Bài 1
        int[] subArray = findSubArray(arr, k);
        System.out.print("Mang co tong "+ k +" phan tu lien tiep nho nhat: ");
        for (int i : subArray) {
            System.out.print(i + " ");
        }
        //Bài 2
        int i = equalSum(arr);
        System.out.println("\nVi tri ma chia 2 phan bang nhau: "+i);
        //Bài 3
         i = majorityFrequent(arr);
         System.out.println("Vi tri nho nhat cua so quan trong trong mang "+i);       
    }
}
