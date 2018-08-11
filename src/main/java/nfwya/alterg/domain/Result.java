package nfwya.alterg.domain;


import java.util.NoSuchElementException;
import java.util.function.Consumer;


/***
 * Представляет результат работы сервиса.
 *
 * @param <V> вычисленное значение.
 * @param <E> ошибка.
 */
public final class Result<V, E extends ApplicationError>
{
    /**
     * Флаг успешности выполнения.
     */
    private final boolean success;

    /**
     * Значение, если результат успешный.
     */
    private final V value;

    /**
     * Ошибка, если результат неуспешный.
     */
    private final E error;


    public static <V, E extends ApplicationError> Result<V, E> success(final V value)
    {
        return new Result<>(true, value, null);
    }


    public static <E extends ApplicationError> Result<Void, E> success()
    {
        return new Result<>(true, null, null);
    }


    public static <V, E extends ApplicationError> Result<V, E> failed(final E error)
    {
        return new Result<>(false, null, error);
    }


    public boolean isSuccess()
    {
        return success;
    }


    //ToDo: что если Void значение/ошибка? Можно ли проверять на null?
    public E getError()
    {
        if (!success)
        {
            return error;
        }
        throw new NoSuchElementException("No value present");
    }


    public V getValue()
    {
        if (success)
        {
            return value;
        }
        throw new NoSuchElementException("No value present");
    }


    /**
     * Если результат неуспешный, применяет функцию к ошибке.
     * Иначе ничего не делает.
     *
     * @param consumer функция.
     */
    public void ifFailed(final Consumer<E> consumer)
    {
        if (consumer != null)
        {
            consumer.accept(error);
        }
    }


    /**
     * Есди результат успешный, применяет функцию к значению.
     * Иначе ничего не делает.
     *
     * @param consumer функция.
     */
    public void ifSuccess(final Consumer<V> consumer)
    {
        if (consumer != null)
        {
            consumer.accept(value);
        }
    }




    private Result(final boolean success, final V value, final E error)
    {
        this.success = success;
        this.value = value;
        this.error = error;
    }


    @Override
    public String toString()
    {
        return "Result{" +
                "success=" + success +
                ", value=" + value +
                ", error=" + error +
                '}';
    }
}
