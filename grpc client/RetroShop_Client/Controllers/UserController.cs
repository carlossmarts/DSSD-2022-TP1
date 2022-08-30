using Grpc.Net.Client;
using Microsoft.AspNetCore.Mvc;
using RetroShop_Client.Protos;

namespace RetroShop_Client.Controllers
{
    [Route("api/usuario")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly string GrpcChannelURL = "https://localhost:7110";
        #region mocks
        private List<Usuario> _usuarios = new List<Usuario>();
        private readonly Usuario usuarioResponse = new Usuario()
        {
            Apellido = "Velasquez",
            Nombre = "Matias",
            Dni = 41716615,
            Email = "matiasvelasquez840@gmail.com",
            Clave = "pass"
        };
        #endregion

        #region endpoints
        // POST api/<UserController>
        [HttpPost]
        public async Task<ActionResult> Post([FromBody] Usuario usuario)
        {
            try
            {
                //using var channel = GrpcChannel.ForAddress(GrpcChannelURL);
                //var client = new UsuarioService.UsuarioServiceClient(channel);
                //var response = client.Post(usuario);
                _usuarios.Add(usuario);
                return Ok(_usuarios.Count);
            }
            catch (Exception ex)
            {
                return BadRequest(ex);
            }
        }
        //GET
        [HttpGet]
        [Route("login")] public async Task<ActionResult> Login([FromBody]UsuarioLogin usuarioLogin)
        {
            return Ok(usuarioResponse);
        }
        #endregion
    }
}
