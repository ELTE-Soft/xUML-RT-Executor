package hu.eltesoft.modelexecution.m2t.smap.xtend

/**
 * Represents a location in a source file.
 * The file path is always a relative path,
 * for example to the source root directory.
 */
@Data
class Location {
    String filePath;
    int startLine;
    int endLine;
}

interface LocationProvider {

    def Location getLocation()
}

/**
 * Arbitrary data packaged with its source location information.
 */
@Data
package class DataWithLocation<T> {
    T data
    Location location

    override toString() {
        data.toString
    }
}

/**
 * Provides various location tracing methods to inject source location information
 * during evaluation of Xtend templates. The class which contains the template
 * method where location tracing used must be annotated with @SourceMappedTemplate.
 */
class TraceExtensions {

    def static <T> DataWithLocation<T> trace(Location location, T data) {
        new DataWithLocation(data, location)
    }

    def static <T> DataWithLocation<T> trace(LocationProvider provider, T data) {
        trace(provider.location, data)
    }

    def static <T extends LocationProvider> DataWithLocation<T> trace(T dataWithLocation) {
        trace(dataWithLocation.location, dataWithLocation)
    }
}
