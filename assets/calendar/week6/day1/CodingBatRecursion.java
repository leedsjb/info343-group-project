
public class CodingBatRecursion {
public int count8(int n) {
  if (n == 0) {
   return 0;
  }
  else {
   int d = n % 10;
   n = n / 10;
   if (d == 8 && n % 10 == 8) {
     return 2 + count8(n);
   }
   else if (d == 8) { // skip the next digit in n since not an 8
     return 1 + count8(n/10);
   }
   else {
     return count8(n);
   }
  }
}
}
