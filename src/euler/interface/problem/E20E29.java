package problem;

import java.util.List;

public interface E20E29 {

    public long getE20(final long number);

    public long getE21(final long number);
    public long functionD(final long value);

    public long getE22(final String filePath);
    public long getScoreName(final String name);

    public long getE23(final long limit);
    public boolean isAbundantNumber(final long number);
    public boolean isSumOfTwoAbundantNumber(final long number);

    public String getE24(final String numberStr, int position);
    public String getFirstElement(final int position, final List<String> list);

    public int getE25(final int digitNumber);

    // NOT OK
    public long getE26(final long limit, final int precision);
    public long getE26(final long limit);

    public long getE27(final long limitA, final long limitB);
    public long getNumberPrime(final long a, final long b);

    public long getE28(final int spiralSize);

    public long getE29(final int limitA, final int limitB);
}
