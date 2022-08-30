using Grpc.Net.Client;
using Microsoft.AspNetCore.Mvc;
using RetroShop_Client.Protos;

namespace RetroShop_Client.Controllers
{
    [Route("api/producto")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        private readonly string GrpcChannelURL = "https://localhost:7110";
        #region mocks
        private List<Producto> _products = new List<Producto>();
        private readonly ServerResponse serverResponseOk = new ServerResponse()
        {
            Cod = 200,
            Msg = "Ok",
        };
        private readonly List<Categoria> _categorias = new List<Categoria>()
        {
            new Categoria() { IdCategoria=1, Categoria_="Vintage" }
        };
        #endregion

        #region endpoints
        // POST api/<ProductController>
        [HttpPost]
        public async Task<ActionResult> Post([FromBody] Producto producto)
        {
            try
            {
                //using var channel = GrpcChannel.ForAddress(GrpcChannelURL);
                //var client = new ProductoService.ProductoServiceClient(channel);
                //var response = client.Post(producto);
                _products.Add(producto);
                return Ok(serverResponseOk);
            }
            catch (Exception ex)
            {
                return BadRequest(new ServerResponse() { Cod = 400, Msg = ex.Message });
            }
        }

        // PUT api/<ProductController>/5
        [HttpPut("{idProducto}")]
        public void Put(int idProducto, [FromBody] Producto producto)
        {
        }
        //GET api/<ProductController>/
        [HttpGet]
        public async Task<ActionResult> GetByFilter([FromBody] ProductoFilter productoFilter)
        {
            return Ok(_products);
        }
        //GET api/<ProductController>/
        [HttpGet]
        [Route("categoria")]
        public async Task<ActionResult> GetAllCategorias()
        {
            return Ok(_categorias);
        }
        #endregion
    }
}
