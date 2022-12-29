public class AStack {

    final static int MIN_STACK_SIZE = 5;
    int topOfStack = -1;
    Object[] array;

    public boolean isEmpty() {
        return array.length == 0;
    }

    public void Stack(int maxElements) {
        int capacity = maxElements;

        if (maxElements < MIN_STACK_SIZE) {
            capacity = MIN_STACK_SIZE;
        }
        array = new Object[capacity];
    }

    public boolean isFull() {
        return (topOfStack == array.length - 1);
    }

    public boolean push(Object x) {
        if (isFull()) {
            return false;
        }  else {
            array[++topOfStack] = x;
            return true;
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            return array[topOfStack--];
        } else {
            return null;
        }
    }

    public Object top() {
        if (!isEmpty()) {
            return array[topOfStack];
        } else {
            return null;
        }
    }

    public boolean checkBalance(AStack check) {
        AStack cache = new AStack();
        while (!check.isEmpty()) {
            if (check.top() == "(" || check.top() == "[" || check.top() == "{") {
                cache.push(check.pop());
            }
            if (check.top() == ")" || check.top() == "]" || check.top() == "}") {
                if (cache.top() != check.top()) {
                    return false;
                } else {
                    cache.pop();
                    check.pop();
                }
            }
            check.pop();
        }
        if (!cache.isEmpty()) {
            return false;
        }
        return true;
    }

    public Object easyCalculator(AStack expression) {
        AStack cache = new AStack();
        while (expression.isEmpty()) {
            if (expression.top() != "+" || expression.top() != "-"
                    || expression.top() != "*" || expression.top() != "/") {
                cache.push(expression.pop());
            }
            if (expression.top() == "+" || expression.top() == "-"
                    || expression.top() == "*" || expression.top() == "/")  {
                Object r_operand = cache.pop();
                Object l_operand = cache.pop();
                Object operator = expression.pop();
                Object result;
                //result = operator(r_operand,r_operand);
                //cache.push(result);
            }
        }
        //return result;
        return 0;
    }
}
