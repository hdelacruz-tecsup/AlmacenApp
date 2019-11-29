package pe.ebenites.almacenapp.services;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.ebenites.almacenapp.models.Producto;
import pe.ebenites.almacenapp.models.Usuario;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {

    String API_BASE_URL = "http://192.168.43.38:8080";

    @GET("/api/productos")  // http://10.0.2.2:8080/productos
    Call<List<Producto>> findAll();

    @FormUrlEncoded
    @POST("/api/productos")
    Call<Producto> createProducto(@Field("nombre") String nombre,
                                  @Field("precio") String precio,
                                  @Field("detalles") String detalles);
    @Multipart
    @POST("/api/productos")
    Call<Producto> createProducto(@Part("nombre") RequestBody nombre,
                                  @Part("precio") RequestBody precio,
                                  @Part("detalles") RequestBody detalles,
                                  @Part MultipartBody.Part imagen
    );

    @DELETE("/api/productos/{id}")
    Call<String> destroyProducto(@Path("id") Long id);

    @GET("/api/productos/{id}")
    Call<Producto> showProducto(@Path("id") Long id);


    @FormUrlEncoded
    @POST("/auth/login")
    Call<Usuario> login(@Field("username") String username,
                        @Field("password") String password);

    @GET("/api/profile")
    Call<Usuario> getProfile();


}
