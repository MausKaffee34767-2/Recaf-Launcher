package software.coley.recaf.launcher.util;

import org.jspecify.annotations.NonNull;
import java.io.IOException;

/**
 * Consumer that throws an {@link IOException}.
 *
 * @param <T>
 * 		Input type.
 */
public interface IOConsumer<T> {
	/**
	 * @param value
	 * 		Input value.
	 *
	 * @throws IOException
	 * 		When the consumer handling fails.
	 */
	void accept(@NonNull T value) throws IOException;
}
