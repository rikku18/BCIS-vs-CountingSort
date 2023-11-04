package TE1;

public class BCIS{
    public void sort(int[] array){
        int lastIndex = array.length-1;
        sort(array, 0, lastIndex);
    }

    private void sort(int[] array, int left, int right){
        int SL= left;
        int SR = right; 
        int i;
        while (SL<SR){
            int calc = Math.round(SL + ((SR-SL)/2));
            swap(array, SR, calc);
            if (isEqual(array, SL, SR)==-1){
                return ;
            }
            if(array[SL]>array[SR]){
                swap(array, SL, SR);
            }

            if(SR-SL>=100){
                for(i=SL+1;i<=(int)Math.sqrt(SR-SL);i++){
                    if(array[SR]<array[i]){
                        swap(array, SR, i);
                    }
                    else if(array[SL]>array[i]){
                        swap(array, SL, i);
                    }
                }
            }
            else{
                i = SL+1;
            }

            int LC = array[SL];
            int RC = array[SR];

            while(i<SR){
                int currItem = array[i];
                if(currItem>=RC){
                    array[i] = array[SR-1];
                    InsRight(array, currItem, SR, right);
                    SR = SR-1;
                }
                else if(currItem<=LC){
                    array[i] = array[SL+1];
                    InsLeft(array, currItem, SL, left);
                    SL += 1;
                    i++;
                }
                else{
                    i++;
                }
            }
            SL++;
            SR--;
        }        
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int isEqual(int[] array, int SL, int SR){
        for(int k = SL+1; k<=SR-1;k++){
            if(array[k]!=array[SL]){
                swap(array, k, SR);
                return k;
            }
        }  
        return -1;
    }

    private void InsRight(int[] array, int currItem, int SR, int right){
        int j = SR;
        while(j<=right && currItem>array[j]){
            array[j-1] = array[j];
            j++;
        }
        array[j-1] = currItem;
    }

    private void InsLeft(int[] array, int currItem, int SL, int left){
        int j = SL;
        while(j>=left && currItem<array[j]){
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = currItem;
    }
}