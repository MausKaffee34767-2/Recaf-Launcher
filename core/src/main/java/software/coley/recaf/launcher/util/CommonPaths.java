package software.coley.recaf.launcher.util;

import software.coley.recaf.launcher.info.PlatformType;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Key directories for Recaf.
 */
public class CommonPaths {
	/**
	 * @return Recaf root directory.
	 */
	@NonNull
	public static Path getRecafDirectory() {
		// Try environment variable first.
		String recafDir = System.getenv("RECAF");
		if (recafDir != null) {
			return Paths.get(recafDir);
		}

		// Otherwise put it in the system's config directory
		Path dir = getSystemConfigDir();
		if (dir == null)
			throw new IllegalStateException("Failed to determine config directory for: " + System.getProperty("os.name"));
		return dir.resolve("Recaf");
	}

	/**
	 * @return Path to Recaf's dependencies directory.
	 */
	@NonNull
	public static Path getDependenciesDir() {
		return getRecafDirectory().resolve("dependencies");
	}

	/**
	 * @return Path to the Recaf launcher's directory for additional resource/config storage.
	 */
	@NonNull
	public static Path getLauncherDir() {
		return getRecafDirectory().resolve("launcher");
	}

	/**
	 * @return Path to Recaf jar.
	 */
	@NonNull
	public static Path getRecafJar() {
		return getRecafDirectory().resolve("recaf.jar");
	}

	/**
	 * @return Path to Recaf temporary jar used in the update process.
	 */
	@NonNull
	public static Path getRecafTempJar() {
		return getRecafDirectory().resolve("recaf-update-tmp");
	}

	/**
	 * @return Path to cli launcher config.
	 */
	@NonNull
	public static Path getCliConfigFile() {
		return getLauncherDir().resolve("config-cli.json");
	}

	/**
	 * @return Path to gui launcher config.
	 */
	@NonNull
	public static Path getGuiConfigFile() {
		return getLauncherDir().resolve("config-gui.json");
	}

	/**
	 * @return Path to file containing snapshot workflow file.
	 */
	@NonNull
	public static Path getSnapshotWorkflowFile() {
		return getLauncherDir().resolve("installed-workflow-id.txt");
	}

	/**
	 * @return Root config directory for the current OS.
	 */
	@Nullable
	private static Path getSystemConfigDir() {
		if (PlatformType.isWindows()) {
			return Paths.get(System.getenv("APPDATA"));
		} else if (PlatformType.isMac()) {
			// Mac-OS paths:
			//  https://developer.apple.com/library/archive/qa/qa1170/_index.html
			return Paths.get(System.getProperty("user.home") + "/Library/Application Support");
		} else if (PlatformType.isLinux()) {
			// $XDG_CONFIG_HOME or $HOME/.config
			String xdgConfigHome = System.getenv("XDG_CONFIG_HOME");
			if (xdgConfigHome != null)
				return Paths.get(xdgConfigHome);
			return Paths.get(System.getProperty("user.home") + "/.config");
		}
		return null;
	}
}
