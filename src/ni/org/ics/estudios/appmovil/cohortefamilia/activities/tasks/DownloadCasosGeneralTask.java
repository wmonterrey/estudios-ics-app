package ni.org.ics.estudios.appmovil.cohortefamilia.activities.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import ni.org.ics.estudios.appmovil.database.EstudiosAdapter;
import ni.org.ics.estudios.appmovil.domain.cohortefamilia.casos.CasaCohorteFamiliaCaso;
import ni.org.ics.estudios.appmovil.domain.cohortefamilia.casos.ParticipanteCohorteFamiliaCaso;
import ni.org.ics.estudios.appmovil.domain.cohortefamilia.casos.VisitaFallidaCaso;
import ni.org.ics.estudios.appmovil.domain.cohortefamilia.casos.VisitaSeguimientoCaso;
import ni.org.ics.estudios.appmovil.domain.cohortefamilia.casos.VisitaSeguimientoCasoSintomas;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.content.Context;
import android.util.Log;



public class DownloadCasosGeneralTask extends DownloadTask {
	
	private final Context mContext;
	
	public DownloadCasosGeneralTask(Context context) {
		mContext = context;
	}
	
	protected static final String TAG = DownloadCasosGeneralTask.class.getSimpleName();
	private EstudiosAdapter estudioAdapter = null;
	
    private List<CasaCohorteFamiliaCaso> mCasaCohorteFamiliaCasos = null;
    private List<ParticipanteCohorteFamiliaCaso> mParticipanteCohorteFamiliaCasos = null;
    private List<VisitaSeguimientoCaso> mVisitaSeguimientoCasos = null;
    private List<VisitaFallidaCaso> mVisitaFallidaCasos = null;
    private List<VisitaSeguimientoCasoSintomas> mVisitaSeguimientoSintomasCasos = null;

	
	public static final String CASAS_CASOS = "1";
    public static final String PART_CASOS = "2";
    public static final String VISITAS_CASOS = "3";
    public static final String VISITAS_FALLIDAS_CASOS = "4";
    public static final String SINTOMAS_CASOS = "5";

    private static final String TOTAL_TASK_CASOS = "5";

	private String error = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private int v =0;

	@Override
	protected String doInBackground(String... values) {
		url = values[0];
		username = values[1];
		password = values[2];
		
		
		try {
			error = descargarDatosCasos();
			if (error!=null) return error;
		} catch (Exception e) {
			// Regresa error al descargar
			e.printStackTrace();
			return e.getLocalizedMessage();
		}
		publishProgress("Abriendo base de datos...","1","1");
		estudioAdapter = new EstudiosAdapter(mContext, password, false,false);
		estudioAdapter.open();
		//Borrar los datos de la base de datos
        estudioAdapter.borrarCasaCohorteFamiliaCaso();
        estudioAdapter.borrarParticipanteCohorteFamiliaCaso();
        estudioAdapter.borrarVisitaSeguimientoCaso();
        estudioAdapter.borrarVisitaFallidaCaso();
        estudioAdapter.borrarVisitaSeguimientoCasoSintomas();
        
		try {
            if (mCasaCohorteFamiliaCasos != null){
                v = mCasaCohorteFamiliaCasos.size();
                ListIterator<CasaCohorteFamiliaCaso> iter = mCasaCohorteFamiliaCasos.listIterator();
                while (iter.hasNext()){
                    estudioAdapter.crearCasaCohorteFamiliaCaso(iter.next());
                    publishProgress("Insertando casas con casos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
                mCasaCohorteFamiliaCasos = null;
            }
            if (mParticipanteCohorteFamiliaCasos != null){
                v = mParticipanteCohorteFamiliaCasos.size();
                ListIterator<ParticipanteCohorteFamiliaCaso> iter = mParticipanteCohorteFamiliaCasos.listIterator();
                while (iter.hasNext()){
                    estudioAdapter.crearParticipanteCohorteFamiliaCaso(iter.next());
                    publishProgress("Insertando participantes de casas con casos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
                mParticipanteCohorteFamiliaCasos = null;
            }
            
            if (mVisitaSeguimientoCasos != null){
                v = mVisitaSeguimientoCasos.size();
                ListIterator<VisitaSeguimientoCaso> iter = mVisitaSeguimientoCasos.listIterator();
                while (iter.hasNext()){
                    estudioAdapter.crearVisitaSeguimientoCaso(iter.next());
                    publishProgress("Insertando visitas de los participantes de casas con casos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
                mVisitaSeguimientoCasos = null;
            }
            
            if (mVisitaFallidaCasos != null){
                v = mVisitaFallidaCasos.size();
                ListIterator<VisitaFallidaCaso> iter = mVisitaFallidaCasos.listIterator();
                while (iter.hasNext()){
                    estudioAdapter.crearVisitaFallidaCaso(iter.next());
                    publishProgress("Insertando visitas fallidas de los participantes de casas con casos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
                mVisitaFallidaCasos = null;
            }
            
            if (mVisitaSeguimientoSintomasCasos != null){
                v = mVisitaSeguimientoSintomasCasos.size();
                ListIterator<VisitaSeguimientoCasoSintomas> iter = mVisitaSeguimientoSintomasCasos.listIterator();
                while (iter.hasNext()){
                    estudioAdapter.crearVisitaSeguimientoCasoSintomas(iter.next());
                    publishProgress("Insertando sintomas de los participantes de casas con casos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
                mVisitaSeguimientoSintomasCasos = null;
            }
            
		} catch (Exception e) {
			// Regresa error al insertar
			e.printStackTrace();
			estudioAdapter.close();
			return e.getLocalizedMessage();
		}
		
		estudioAdapter.close();
		return error;
	}
    // url, username, password
    protected String descargarDatosCasos() throws Exception {
        try {
            // The URL for making the GET request
            String urlRequest;
            // Set the Accept header for "application/json"
            HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
            HttpHeaders requestHeaders = new HttpHeaders();
            List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
            acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
            requestHeaders.setAccept(acceptableMediaTypes);
            requestHeaders.setAuthorization(authHeader);
            // Populate the headers in an HttpEntity object to use for the request
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

            //Descargar casas con casos
            urlRequest = url + "/movil/casascasos/";
            publishProgress("Solicitando casas de casos",CASAS_CASOS,TOTAL_TASK_CASOS);
            // Perform the HTTP GET request
            ResponseEntity<CasaCohorteFamiliaCaso[]> responseEntityCasaCohorteFamiliaCasos = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
            		CasaCohorteFamiliaCaso[].class);
            // convert the array to a list and return it
            mCasaCohorteFamiliaCasos = Arrays.asList(responseEntityCasaCohorteFamiliaCasos.getBody());
            responseEntityCasaCohorteFamiliaCasos = null;
            
            //Descargar participantes de casas con casos
            urlRequest = url + "/movil/participantescasos/";
            publishProgress("Solicitando participantes de casas de casos",PART_CASOS,TOTAL_TASK_CASOS);
            // Perform the HTTP GET request
            ResponseEntity<ParticipanteCohorteFamiliaCaso[]> responseEntityParticipanteCohorteFamiliaCasos = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
            		ParticipanteCohorteFamiliaCaso[].class);
            // convert the array to a list and return it
            mParticipanteCohorteFamiliaCasos = Arrays.asList(responseEntityParticipanteCohorteFamiliaCasos.getBody());
            responseEntityParticipanteCohorteFamiliaCasos = null;
            
            //Descargar visitas de casas con casos
            urlRequest = url + "/movil/visitascasos/";
            publishProgress("Solicitando visitas de los participantes de casas de casos",PART_CASOS,TOTAL_TASK_CASOS);
            // Perform the HTTP GET request
            ResponseEntity<VisitaSeguimientoCaso[]> responseEntityVisitaSeguimientoCasos = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
            		VisitaSeguimientoCaso[].class);
            // convert the array to a list and return it
            mVisitaSeguimientoCasos = Arrays.asList(responseEntityVisitaSeguimientoCasos.getBody());
            responseEntityVisitaSeguimientoCasos = null;
            
            //Descargar visitas fallidas de casas con casos
            urlRequest = url + "/movil/visitasfallidascasos/";
            publishProgress("Solicitando visitas fallidas de los participantes de casas de casos",VISITAS_FALLIDAS_CASOS,TOTAL_TASK_CASOS);
            // Perform the HTTP GET request
            ResponseEntity<VisitaFallidaCaso[]> responseEntityVisitaFallidaCasos = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
            		VisitaFallidaCaso[].class);
            // convert the array to a list and return it
            mVisitaFallidaCasos = Arrays.asList(responseEntityVisitaFallidaCasos.getBody());
            responseEntityVisitaFallidaCasos = null;
            
            //Descargar sintomas de casas con casos
            urlRequest = url + "/movil/sintomascasos/";
            publishProgress("Solicitando sintomas de los participantes de casas de casos",SINTOMAS_CASOS,TOTAL_TASK_CASOS);
            // Perform the HTTP GET request
            ResponseEntity<VisitaSeguimientoCasoSintomas[]> responseEntityVisitaSeguimientoCasoSintomas = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
            		VisitaSeguimientoCasoSintomas[].class);
            // convert the array to a list and return it
            mVisitaSeguimientoSintomasCasos = Arrays.asList(responseEntityVisitaSeguimientoCasoSintomas.getBody());
            responseEntityVisitaSeguimientoCasoSintomas = null;
            
            return null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getLocalizedMessage();
        }
    }
}
