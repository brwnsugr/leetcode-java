package written.leetcode.amazon.ArrayAndStrings;

public class CompareVersionNumbers165 {

  public int compareVersion(String version1, String version2) {
    /**
     * 1.0.1 -> 1,0,1
     * 1.0 -> 1,0(,0) => compare = 1
     *
     *
     * 1.01 -> 1,1
     * 1.001 -> 1,1  => compare = 0
     *
     * 1.0 -> 1,0(,0)
     * 1.0.0 -> 1,0,0 => compare = 0
     *
     *
     * 0.1 -> 0,1
     * 1.1 -> 1,1 => compare = -1
     */

    String[] version1s = version1.split("\\.");
    String[] version2s = version2.split("\\.");

    int[] version1Nums = new int[version1s.length];
    int[] version2Nums = new int[version2s.length];

    for(int i = 0; i < version1s.length; i++) {
      version1Nums[i] = Integer.valueOf(version1s[i]);
    }

    for(int j = 0; j < version2s.length; j++) {
      version2Nums[j] = Integer.valueOf(version2s[j]);
    }

    int biggerPoints = Math.max(version1Nums.length, version2Nums.length);
    int smallerPoints = Math.min(version1Nums.length, version2Nums.length);

    for(int i = 0; i < biggerPoints; i++) {
      while(i < smallerPoints) {
        if(version1Nums[i] < version2Nums[i]) return -1;
        else if(version1Nums[i] > version2Nums[i]) return 1;
        i++;
      }
      while(i < biggerPoints) {
        if(biggerPoints == version1Nums.length) {
          if (version1Nums[i] > 0) return 1;
        }
        else {
          if(version2Nums[i] > 0) return -1;
        }
        i++;
      }
    }
    return 0;
  }

  public int compareVersion2(String version1, String version2) {
    String[] nums1 = version1.split("\\.");
    String[] nums2 = version2.split("\\.");

    int biggerSize = Math.max(nums1.length, nums2.length);
    int nums1Len = nums1.length;
    int nums2Len = nums2.length;

    for(int i = 0; i < biggerSize; i++) {
      int n1 = i < nums1Len ? Integer.valueOf(nums1[i]) : 0;
      int n2 = i < nums2Len ? Integer.valueOf(nums2[i]) : 0;
      if(n1 != n2) {
        return n1 > n2 ? 1 : -1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    CompareVersionNumbers165 compareVersionNumbers165 = new CompareVersionNumbers165();
    String v1 = "1.01";
    String v2 = "1.001";
    int i = compareVersionNumbers165.compareVersion(v1, v2);
    System.out.println("ddd is " + i);
  }

}
