package WS09.WS09_PS10;

public class SevenSegDigit {

    public enum ElState {
        ON,
        OFF
    }

    private static final int LEFT_TOP = 0,
            LEFT_BOTTOM = 1,
            MIDDLE_TOP = 2,
            MIDDLE_CENTRE = 3,
            MIDDLE_BOTTOM = 4,
            RIGHT_TOP = 5,
            RIGHT_BOTTOM = 6;

    private final int digit;

    public SevenSegDigit(int digit)
    {
        if (digit<0||digit>9)
        {
            throw new IllegalArgumentException("only digits [0..9] can be represented by a seven segment display");
        }

        this.digit=digit;
    }

    public int getDigit()
    {
        return this.digit;
    }


    public String toString()
    {
        return Integer.valueOf(getDigit()).toString();
    }

    public final ElState[] getSegStates()
    {

        ElState[] state = new ElState[7];

        for (int i=0; i<state.length; i++)
        {
            state[i] = ElState.OFF;
        }

        switch (digit) {

            case 9:
                state[LEFT_TOP] = ElState.ON;
                state[MIDDLE_CENTRE] = ElState.ON;
            case 7:
                state[MIDDLE_TOP] = ElState.ON;
            case 1:
                state[RIGHT_TOP]    = ElState.ON;
                state[RIGHT_BOTTOM] = ElState.ON;
                break;
            case 3:
                state[MIDDLE_CENTRE] = ElState.ON;
                state[MIDDLE_BOTTOM] = ElState.ON;
                state[MIDDLE_TOP]    = ElState.ON;
                state[RIGHT_TOP]    = ElState.ON;
                state[RIGHT_BOTTOM] = ElState.ON;
                break;
            case 2:
                state[MIDDLE_TOP] = ElState.ON;
                state[MIDDLE_CENTRE] = ElState.ON;
                state[MIDDLE_BOTTOM] = ElState.ON;
                state[RIGHT_TOP] = ElState.ON;
                state[LEFT_BOTTOM] = ElState.ON;
                break;
            case 5:
                state[MIDDLE_TOP] = ElState.ON;
                state[MIDDLE_CENTRE] = ElState.ON;
                state[MIDDLE_BOTTOM] = ElState.ON;
                state[LEFT_TOP] = ElState.ON;
                state[RIGHT_BOTTOM] = ElState.ON;
                break;
            case 4:
                state[LEFT_TOP] = ElState.ON;
                state[MIDDLE_CENTRE] = ElState.ON;
                state[RIGHT_TOP] = ElState.ON;
                state[RIGHT_BOTTOM] = ElState.ON;
                break;
            case 6:
                state[LEFT_TOP] = ElState.ON;
                state[LEFT_BOTTOM] = ElState.ON;
                state[MIDDLE_TOP] = ElState.ON;
                state[MIDDLE_CENTRE] = ElState.ON;
                state[MIDDLE_BOTTOM] = ElState.ON;
                state[RIGHT_BOTTOM] = ElState.ON;
                break;
            case 0:
                for (int i=0; i<state.length; i++)
                {
                    if (i!=MIDDLE_CENTRE) { state[i] = ElState.ON; }
                }
                break;
            case 8:
                for (int i=0; i<state.length; i++)
                {
                    state[i] = ElState.ON;
                }
                break;

        }


        return state;
    }

}
