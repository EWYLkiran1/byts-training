class Solution {
    public int findMin(int[] FJH) 
        {
			int left = 0;
			int right = FJH.length - 1;
			while (left < right)
			{			
				int mid = left+(right-left) / 2;
				if (FJH[mid] > FJH[right] ) {
					left=mid+1;
				}
				else if (FJH[mid] < FJH[right]) {
					right = mid;
				}
				else
                right--;
			}
			return FJH[left];
		}
}
