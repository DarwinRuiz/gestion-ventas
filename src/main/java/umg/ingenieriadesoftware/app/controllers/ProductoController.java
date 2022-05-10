package umg.ingenieriadesoftware.app.controllers;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import umg.ingenieriadesoftware.app.models.entity.Producto;
import umg.ingenieriadesoftware.app.models.service.ProductoServiceImpl;
import umg.ingenieriadesoftware.app.util.paginator.PageRender;

@Controller
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private ProductoServiceImpl productoService;

	@Autowired
	private MessageSource messageSource;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/listar_productos")
	public String listarProductos(@RequestParam(name = "page", defaultValue = "0") int page, Model model,
			Authentication authentication, HttpServletRequest request, Locale locale) {

		model.addAttribute("titulo", "Productos");

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Producto> productos = productoService.findAll(pageRequest);

		PageRender<Producto> pageRender = new PageRender<Producto>("/listar_productos", productos);

		model.addAttribute("productos", productos);
		model.addAttribute("page", pageRender);

		return "listar_productos";
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/buscar_categoria")
	public String listarBusqueda(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "busqueda_categoria") String categoria, Model model,
			Authentication authentication, HttpServletRequest request, Locale locale) {

		model.addAttribute("titulo", "Productos");

		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Producto> productos = productoService.findAllByCategory(categoria, pageRequest);

		PageRender<Producto> pageRender = new PageRender<Producto>("/listar_productos", productos);

		model.addAttribute("productos", productos);
		model.addAttribute("page", pageRender);

		return "listar_productos";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/form_productos")
	public String crear(Map<String, Object> model, Locale locale) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", messageSource.getMessage("text.producto.form.titulo.crear", null, locale));
		return "form_productos";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/form_productos", method = RequestMethod.POST)
	public String guardarProducto(@Valid Producto producto, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status, Locale locale) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", messageSource.getMessage("text.producto.form.titulo", null, locale));
			return "form_productos";
		}

		String mensajeFlash = (producto.getId() != null)
				? messageSource.getMessage("text.producto.flash.editar.success", null, locale)
				: messageSource.getMessage("text.producto.flash.crear.success", null, locale);

		productoService.save(producto);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar_productos";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/form_productos/{id}")
	public String editarProducto(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash, Locale locale) {

		Producto producto = null;

		if (id > 0) {
			producto = productoService.findOne(id);
			if (producto == null) {
				flash.addFlashAttribute("error",
						messageSource.getMessage("text.producto.flash.db.error", null, locale));
				return "redirect:/listar_productos";
			}
		} else {
			flash.addFlashAttribute("error", messageSource.getMessage("text.producto.flash.id.error", null, locale));
			return "redirect:/listar_productos";
		}
		model.put("producto", producto);
		model.put("titulo", messageSource.getMessage("text.producto.form.titulo.editar", null, locale));
		return "form_productos";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/eliminar_producto/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash, Locale locale) {

		if (id > 0) {
			Producto producto = productoService.findOne(id);

			productoService.delete(id);
			flash.addFlashAttribute("success",
					messageSource.getMessage("text.producto.flash.eliminar.success", null, locale));
		}
		return "redirect:/listar_productos";
	}
}
