package software.coley.recaf.launcher.util;

import org.jspecify.annotations.NonNull;
import java.io.IOException;

/**
 * Function that throws an {@link IOException}.
 *
 * @param <T>
 * 		Input type.
 * @param <R>
 * 		Return type.
 */
public interface IOFunction<T, R> {
	/**
	 * @param value
	 * 		Input value.
	 *
	 * @return Return value. Should never be {@code null}.
	 *
	 * @throws IOException
	 * 		When the function mapping fails.
	 */
	@NonNull
	R apply(@NonNull T value) throws IOException;
}
