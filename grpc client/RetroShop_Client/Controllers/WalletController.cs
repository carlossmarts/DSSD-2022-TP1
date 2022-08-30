using Microsoft.AspNetCore.Mvc;
using RetroShop_Client.Protos;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace RetroShop_Client.Controllers
{
    [Route("api/billetera")]
    [ApiController]
    public class WalletController : ControllerBase
    {
        #region mocks
        private readonly UsuarioResp usuarioResponse = new UsuarioResp()
        {
            Apellido = "Velasquez",
            Nombre = "Matias",
            Dni = 41716615,
            Email = "matiasvelasquez840@gmail.com",
            Clave = "pass"
        };
        #endregion

        #region endpoints
        // POST api/<WalletController>
        [HttpPost]
        [Route("pago")]
        public async Task<ActionResult> Pagar([FromBody] PagoProducto pagoProducto)
        {
            return Ok(usuarioResponse);
        }

        // PUT api/<WalletController>/5
        [HttpPut]
        [Route("saldo")]
        public async Task<ActionResult> CargarSaldo([FromBody] CargaSaldo cargaSaldo)
        {
            return Ok(usuarioResponse);
        }
        #endregion
    }
}
