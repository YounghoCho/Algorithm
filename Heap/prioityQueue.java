import java.util.*;
import java.lang.*;
import java.io.*;
class Ideone{
  public static void main(String[] args) {
        Heap mHeap = new Heap(8);
        System.out.println("Insert 5,7,8,9,4,2,3,1");
        mHeap.insert(5);
        mHeap.insert(7);
        mHeap.insert(8);
        mHeap.insert(9);
        mHeap.insert(4);
        mHeap.insert(2);
        mHeap.insert(3);
        mHeap.insert(1);
        mHeap.print();
 
        System.out.println("");
        System.out.println("Delete");
        mHeap.delete();
        mHeap.print();
 
        System.out.println("");
        System.out.println("Delete");
        mHeap.delete();
        mHeap.print();
    }
}

class Heap{
    int totalSize;
    int usedSize;
    int[] heapArray;
     
     
    public Heap(int size){
        totalSize = size;
        heapArray = new int[totalSize]; // Size 에 맞게 배열 생성
        usedSize = 0;
    }
     
    public void insert(int data){
        int currentPosition = usedSize;
        int parentPosition = getParentPosition(currentPosition);
         
        if(usedSize == totalSize) return; 
        // 용량 초과
         
        heapArray[currentPosition] = data; 
        // 힙의 가장 최고의 깊이의 왼쪽부터 채웠을 때 맨 오른쪽에 삽입한다.
         
        while (currentPosition > 0
                && heapArray[currentPosition] < heapArray[parentPosition]) { 
            // 루트노드까지 & 부모노드가 더 작을 때 까지 작업을 반복한다.
            swap(heapArray, currentPosition, parentPosition);
            currentPosition = parentPosition;
            parentPosition = getParentPosition(currentPosition);
        }
        usedSize += 1;
    }
     
    public void delete(){
        if(usedSize==0) return; // 삭제할 것이 없다.
        usedSize -= 1;
         
        int currentPosition = 0;
        int leftChildPosition = getLeftChildPosition(currentPosition);
        int rightChildPosition = getRightChildPosition(currentPosition);
         
        heapArray[currentPosition] = 0; // 삭제
        swap(heapArray, currentPosition, usedSize); 
        // 힙의 가장 최고의 깊이의 왼쪽부터 채웠을 때 맨 오른쪽에 노드를 Root노드로 이동한다.
         
        while(true){ 
            // 더이상 작업이 없는 리프노드가 되거나, 양쪽 자식보다 작은 값을 가질 때까지 작업을 반복한다.
            int selectChildPosition = 0;
            if (leftChildPosition >= usedSize)
                break; 
            // 왼쪽 자식노드 위치와 사용 크기와 같거나 크다면 리프노드이다. 
            if (rightChildPosition >= usedSize)
                selectChildPosition = leftChildPosition; 
            // 오른쪽 자식노드 위치와 사용크기가 같거나 크다면 자식노드는 왼쪽밖에 없다. 왼쪽을 선택한다.
            else{ 
                // 자식노드가 양쪽 다 있기 때문에 작은 쪽을 선택한다.
                if (heapArray[leftChildPosition] > heapArray[rightChildPosition]) 
                    selectChildPosition = rightChildPosition;
                else selectChildPosition = leftChildPosition;
            }
             
            if (heapArray[selectChildPosition] < heapArray[currentPosition]) { 
                // 자식노드가 더 작다면 바꿔준다.
                swap(heapArray, selectChildPosition, currentPosition);
                currentPosition = selectChildPosition;
            } else
                break;
 
            leftChildPosition = getLeftChildPosition(currentPosition);
            rightChildPosition = getLeftChildPosition(currentPosition);
            //자식 Position Update
        }
         
    }
     
    public void swap(int[] array, int index1, int index2) 
     
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
     
    public int getParentPosition(int subPosition){
        return (int) ((subPosition-1)/2); 
        // k번째 인덱스의 위치에서 부모노드 (k-1) / 2
    }
     
    public int getLeftChildPosition(int parentPosition){
        return 2*parentPosition+1; 
        // k번째 인덱스의 위치에서 왼쪽 자식노드 2K+1
    }
     
    public int getRightChildPosition(int parentPosition){
        return 2*parentPosition+2;
        // k번째 인덱스의 위치에서 오른쪽 자식노드 2K+2
    }
     
    public void print(){
        int depth = 0;
        int position = 0;
        for(int i=0;i<usedSize;i++){
            if(position == i){
                if(position!=0) System.out.println("");
                System.out.println("Depth : " + depth);
                position = position + (int) Math.pow(2, depth);
                depth += 1;
            }
            System.out.print(heapArray[i] + " ");
        }
        System.out.println("");
    }
}
